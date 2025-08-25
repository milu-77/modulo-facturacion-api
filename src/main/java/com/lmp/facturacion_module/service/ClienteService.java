package com.lmp.facturacion_module.service;

import com.lmp.facturacion_module.dto.ClienteDTO;
import com.lmp.facturacion_module.model.Cliente;
import com.lmp.facturacion_module.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public  class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public List<ClienteDTO> getAllClientes(){
        return clienteRepository.findAll()
                .stream()
                .map(ClienteDTO ::fromCliente)
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
}
