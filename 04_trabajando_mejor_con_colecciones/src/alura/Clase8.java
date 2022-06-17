package alura;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import alura.model.Curso;

public class Clase8 {

	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("curso de fisica", 200));
        cursos.add(new Curso("curso de java 8", 500));
        cursos.add(new Curso("curso de geometria del espacio", 400));
        cursos.add(new Curso("curso de historia universal", 300));

        cursos.sort(Comparator.comparing(Curso::getHoras));

        int suma =cursos.stream().mapToInt(x->x.getHoras()).sum();

        OptionalInt max = cursos.stream().mapToInt(x->x.getHoras()).max();

        boolean validaTodos = cursos.stream().allMatch(x-> x.getHoras() > 200);

        Optional<Curso> optionalCurso = cursos.stream().filter(x-> x.getHoras()>300).findFirst();

        if(optionalCurso.isPresent()) {
            System.out.println(optionalCurso.get().getNombre());
        }
	}
}