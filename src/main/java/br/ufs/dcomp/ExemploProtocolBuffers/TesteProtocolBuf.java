package br.ufs.dcomp.ExemploProtocolBuffers;

/**
 * Hello world!
 *
 */
public class TesteProtocolBuf 
{
    public static void main( String[] args )
    {

        // Agrupando dados do primeiro telefone
        Aluno.Builder bFone1 = ContatoProto.Telefone.newBuilder();
        bFone1.setNumero("79 99999-0000");
        bFone1.setTipo(ContatoProto.Tipo.MOVEL);
        
        // Agrupando dados do segundo telefone
        Telefone.Builder bFone2 = ContatoProto.Telefone.newBuilder();
        bFone2.setNumero("79 3200-2323");
        bFone2.setTipo(ContatoProto.Tipo.CASA);

        // Agrupando dados do contato do aluno com os dois telefones acima
        Builder builderAluno = ContatoProto.Aluno.newBuilder();
        builderAluno.setMatricula(123456);
        builderAluno.setNome("Morpheus Santos Sá");
        builderAluno.setEmail("morpheus@dcomp.ufs.br");
        builderAluno.addTelefones(bFone1);
        builderAluno.addTelefones(bFone2);
        
        // Obtendo o contato do aluno
        ContatoProto.Aluno contatoAluno = builderAluno.build();
        
        
        
        
        
        
/*        ContatoAluno.Aluno mensagemContato = 
            ContatoProto.Aluno.newBuilder()
                .setMatricula(123456)
                .setNome("Morpheus Santos Sá")
                .setEmail("morpheus@dcomp.ufs.br")
                .addTelefones(
                    ContatoProto.Telefone.newBuilder()
                        .setNumero("79 98888-0000")
                        .setTipo()

        .build();
        */
    }
}
