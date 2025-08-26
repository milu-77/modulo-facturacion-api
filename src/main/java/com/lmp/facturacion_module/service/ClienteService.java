package com.lmp.facturacion_module.service;

import com.lmp.facturacion_module.dto.ClienteDTO;
import com.lmp.facturacion_module.dto.request.CrearClienteDTO;
import com.lmp.facturacion_module.exception.ClienteServiceException;
import com.lmp.facturacion_module.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public List<ClienteDTO> getAllClientes() {
        return clienteRepository.findAll()
                .stream()
                .map(ClienteDTO::fromCliente)
                .collect(Collectors.toList());
    }


    public ClienteDTO getByID(Long id) {
        return ClienteDTO.fromCliente(clienteRepository.getReferenceById(id));
    }

    public ClienteDTO getByCUIT(String cuit) {
        return ClienteDTO.fromCliente(clienteRepository.getReferenceByCuit(cuit));
    }

    public ClienteDTO getByRazonSocial(String razonSocial) {
        return ClienteDTO.fromCliente(clienteRepository.getReferenceByRazonSocial(razonSocial));
    }

    public ResponseEntity<?> addCliente(@Valid CrearClienteDTO cliente) {
        if (clienteRepository.existsByCuitOrRazonSocial(cliente.getCuit(), cliente.getRazonSocial())) {
            throw new ClienteServiceException("Cliente ya dado de alta");
        }
        System.out.println("CLIENTE AGREGADO ");
         return null;
    }

}
