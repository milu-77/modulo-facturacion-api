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

    public List<ClienteDTO> getClientes(){
        return clienteRepository.findAll()
                .stream()
                .map(ClienteDTO ::fromCliente)
                .collect(Collectors.toList());
     }



}
