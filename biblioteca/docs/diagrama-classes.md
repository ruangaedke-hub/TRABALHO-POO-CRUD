# Diagrama de Classes — Sistema Biblioteca

```mermaid
classDiagram
    direction LR

    class Categoria {
        -Long id
        -String nome
        -String descricao
        -List~Livro~ livros
        +getQuantidadeLivros() int
    }

    class Autor {
        -Long id
        -String nome
        -String nacionalidade
        -String biografia
        -List~Livro~ livros
        +getQuantidadeLivros() int
    }

    class Livro {
        -Long id
        -String titulo
        -String isbn
        -Integer anoPublicacao
        -Integer numeroPaginas
        -String sinopse
        -Autor autor
        -Categoria categoria
    }

    Autor "1" --> "0..*" Livro : possui
    Categoria "1" --> "0..*" Livro : classifica
```

## Relacionamentos

| Relacionamento | Tipo | Descrição |
|---|---|---|
| Autor → Livro | OneToMany | Um autor pode ter muitos livros |
| Categoria → Livro | OneToMany | Uma categoria agrupa muitos livros |
| Livro → Autor | ManyToOne | Cada livro pertence a um único autor |
| Livro → Categoria | ManyToOne | Cada livro pertence a uma única categoria |

## Regras de negócio

- Um **Autor** não pode ser deletado se possuir livros associados
- Uma **Categoria** não pode ser deletada se possuir livros associados
- **ISBN** deve ser único por livro
- **Nome** da categoria deve ser único
