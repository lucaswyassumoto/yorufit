package com.yoru.fit.service;

import com.yoru.fit.entity.Equipamento;
import com.yoru.fit.repository.EquipamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipamentoService {

    private final EquipamentoRepository equipamentoRepository;

    public EquipamentoService(EquipamentoRepository equipamentoRepository) {
        this.equipamentoRepository = equipamentoRepository;
    }

    public Equipamento addEquipamento(Equipamento equipamento){

        if(equipamento.getNome() == null || equipamento.getNome().isBlank()){
            throw new IllegalArgumentException("Você precisa digitar o nome do equipamento");
        }

        String nome = equipamento.getNome().trim();

        if(equipamentoRepository.existsByNome(nome)){
            throw new IllegalArgumentException("Já existe um equipamento com este nome");
        }

        equipamento.setNome(nome);

        if(equipamento.getDescricao() == null || equipamento.getDescricao().isBlank()){
            throw new IllegalArgumentException("Você precisa escrever a descrição do equipamento");
        }

        equipamento.setDescricao(
                equipamento.getDescricao().trim()
        );

        if(equipamento.getImagemUrl() != null && !equipamento.getImagemUrl().isBlank()){
            equipamento.setImagemUrl(
                    equipamento.getImagemUrl().trim()
            );
        }

        return equipamentoRepository.save(equipamento);

    }

    public Equipamento editarEquipamento(Equipamento equipamento, Long equipamentoId){

        Equipamento equipamentoBanco = equipamentoRepository.findById(equipamentoId).orElseThrow(() ->
                new IllegalArgumentException("Equipamento não encontrado"));

        if(equipamento.getNome() != null && !equipamento.getNome().isBlank()){

            String nome = equipamento.getNome().trim();

            if(equipamentoRepository.existsByNomeAndIdNot(nome, equipamentoId)){
                throw new IllegalArgumentException("Esse nome já pertence a um equipamento");
            }

            equipamentoBanco.setNome(nome);
        }

        if(equipamento.getDescricao() != null && !equipamento.getDescricao().isBlank()){
            equipamentoBanco.setDescricao(equipamento.getDescricao().trim());
        }

        if(equipamento.getImagemUrl() != null && !equipamento.getImagemUrl().isBlank()){
            equipamentoBanco.setImagemUrl(equipamento.getImagemUrl().trim());
        }

        return equipamentoRepository.save(equipamentoBanco);

    }

    public void deletarEquipamento(Long equipamentoId){

        Equipamento equipamento = equipamentoRepository.findById(equipamentoId).orElseThrow(() ->
                new IllegalArgumentException("Equipamento não encontrado"));

        equipamentoRepository.delete(equipamento);

    }

    public List<Equipamento> listarEquipamentos(){
        return equipamentoRepository.findAll();
    }

}
