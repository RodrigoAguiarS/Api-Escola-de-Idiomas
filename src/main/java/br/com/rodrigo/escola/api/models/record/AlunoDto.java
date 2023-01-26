package br.com.rodrigo.escola.api.models.record;

import java.util.List;
import java.util.stream.Collectors;

import br.com.rodrigo.escola.api.models.Aluno;
import lombok.Data;

@Data
public class AlunoDto {
    private Long id;
    private String nome;
    private SerieDto serie;
    private List<TurmaDto> turmas;


    public Aluno toEntity() {
        Aluno aluno = new Aluno();
        aluno.setId(id);
        aluno.setNome(nome);
        aluno.setSerie(serie.toEntity());
        aluno.setTurmas(turmas.stream().map(TurmaDto::toEntity).collect(Collectors.toList()));
        return aluno;
    }

    public static AlunoDto toDto(Aluno aluno) {
        AlunoDto dto = new AlunoDto();
        dto.setId(aluno.getId());
        dto.setNome(aluno.getNome());
        dto.setSerie(SerieDto.toDto(aluno.getSerie()));
        dto.setTurmas(aluno.getTurmas().stream().map(TurmaDto::toDto).collect(Collectors.toList()));
        return dto;
    }
}





