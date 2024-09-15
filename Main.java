
interface Ave {
    void voar();
    void emitirSom();
}

class Pato implements Ave {
    @Override
    public void voar() {
        System.out.println("O pato está voando!");
    }

    @Override
    public void emitirSom() {
        System.out.println("O pato está grasnando: Quack!");
    }
}

class Pavao implements Ave {
    @Override
    public void voar() {
        System.out.println("O pavão não consegue voar.");
    }

    @Override
    public void emitirSom() {
        System.out.println("O pavão está cantando: Que som lindo!");
    }
}

class PatoDomestico extends Pato {
}

class PavaoAzul extends Pavao {
}

class PavaoAdapter implements Ave {
    private Pavao pavao;

    public PavaoAdapter(Pavao pavao) {
        this.pavao = pavao;
    }

    @Override
    public void voar() {
        System.out.println("Este pavão não pode voar.");
    }

    @Override
    public void emitirSom() {
        pavao.emitirSom();
    }
}

public class Main {
    public static void main(String[] args) {
        Ave patoDomestico = new PatoDomestico();
        System.out.println("Pato Doméstico:");
        patoDomestico.voar();
        patoDomestico.emitirSom();

        Pavao pavaoAzul = new PavaoAzul();
        Ave pavaoAdaptado = new PavaoAdapter(pavaoAzul);

        System.out.println("\nPavão Azul (adaptado):");
        pavaoAdaptado.voar();
        pavaoAdaptado.emitirSom();
    }
}

}