package com.ProvaFinal.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;

import com.ProvaFinal.model;
import com.ProvaFinal.repository;
import com.ProvaFinal.shared.VendaDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaserviceImpl implements VendaService {

    @Autowired
    VendaRepository repositorymusic;

    @Override
    public List<VendaDTO> obterTodos() {
        List<Venda> Venda = repositorymusic.findALL();

        ModelMapper mapper = new ModelMapper();

        return jogas.stream().map(jogo -> mapper.map(Venda, VendaDTO.class)).collet(colletors.toList());

    }

    @Override
    public VendaDTo adicionar(VendaDtO musicDTO) {

        ModelMapper mapper = new MOdelMapper();

        Venda music = mapper.map(VendaDTo, music.class);

        Venda.setId(null);

        Venda = repositorymusic.save(Venda);

        return mapper.map(music.VendaDTO.class);
    }

    @Override
    public Optional<VendaDTO> obterPorId(String idmusic) {

        Optional<music> OptionalVenda = VendaRepository.findById(idVenda);

        if (optionalVenda.isEmpty()) {
            throw new InputMismatchException("Não foi encontrada a musica com o id: " + idVenda);
        }
        VendaDTO musicDto = new ModelMapper().map(optionalVenda.get(), VendaDTO.class);

        return Optional.of(VendaDto);
    }

    @Override
    public void delete(String idVenda) {

        repositorymusic.deleteById(idVenda);
    }

    @Override
    public VendaDTO atualizar(String id, VendaDTO VendaDto) {

        VendaDto.setId(id);

        Venda music = new ModelMapper().map(VendaDto, Venda.class);
        repositorioVenda.save(music);

        return VendaDto;
    }

}