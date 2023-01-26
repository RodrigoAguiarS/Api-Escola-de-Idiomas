package br.com.rodrigo.escola.api.models.record;
import br.com.rodrigo.escola.api.models.Matricula;
import lombok.Data;

@Data
public class MatriculaDto {
    private Long id;
    private AlunoDto aluno;
    private TurmaDto turma;

    public Matricula toEntity() {
        Matricula matricula = new Matricula();
        matricula.setId(id);
        matricula.setAluno(aluno.toEntity());
        matricula.setTurma(turma.toEntity());
        return matricula;
    }

    public static MatriculaDto toDto(Matricula matricula) {
        MatriculaDto dto = new MatriculaDto();
        dto.setId(matricula.getId());
        dto.setAluno(AlunoDto.toDto(matricula.getAluno()));
        dto.setTurma(TurmaDto.toDto(matricula.getTurma()));
        return dto;
    }
}