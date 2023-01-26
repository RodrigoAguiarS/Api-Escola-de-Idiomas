package br.com.rodrigo.escola.api.models.record;

import java.util.List;
import java.util.stream.Collectors;

import br.com.rodrigo.escola.api.models.Serie;
import lombok.Data;

@Data
public class SerieDto {
    private Long id;
    private String nome;
    private List<AlunoDto> alunos;
    private List<ProfessorDto> professores;

    public Serie toEntity() {
        Serie serie = new Serie();
        serie.setId(id);
        serie.setNome(nome);
        serie.setAlunos(alunos.stream().map(AlunoDto::toEntity).collect(Collectors.toList()));
        serie.setProfessores(professores.stream().map(ProfessorDto::toEntity).collect(Collectors.toList()));
        return serie;
    }

    public static SerieDto toDto(Serie serie) {
        SerieDto dto = new SerieDto();
        dto.setId(serie.getId());
        dto.setNome(serie.getNome());
        dto.setAlunos(serie.getAlunos().stream().map(AlunoDto::toDto).collect(Collectors.toList()));
        dto.setProfessores(serie.getProfessores().stream().map(ProfessorDto::toDto).collect(Collectors.toList()));
        return dto;
    }
}