package br.ufs.dcomp.ExemploProtocolBuffers;

import java.io.FileOutputStream;
import java.io.File;
import com.google.protobuf.util.JsonFormat;

public class ExemploSerializacao {
    public static void main(String[] args) throws Exception {
        
        // Dados do primeiro telefone
        ContatoProto.Telefone fone1 = ContatoProto.Telefone.newBuilder()
                .setNumero("79 99999-0000")
                .setTipo(ContatoProto.Tipo.MOVEL)
                .build();

        // Dados do segundo telefone
        ContatoProto.Telefone fone2 = ContatoProto.Telefone.newBuilder()
                .setNumero("79 3200-2323")
                .setTipo(ContatoProto.Tipo.CASA)
                .build();

        // Dados do contato do aluno com os dois telefones acima
        ContatoProto.Aluno contatoAluno = ContatoProto.Aluno.newBuilder()
                .setMatricula(123456)
                .setNome("Morpheus Santos Sá")
                .setEmail("morpheus@dcomp.ufs.br")
                .addTelefones(fone1)
                .addTelefones(fone2)
                .build();

        // Serializando o contato
        byte[] buffer = contatoAluno.toByteArray();

        // Escrevendo contato já serializado em arquivo
        FileOutputStream fos = new FileOutputStream(new File("aluno.bin"));
        fos.write(buffer);
        fos.close();
        System.out.println("Contato escrito em formato binário no arquivo \"aluno.bin\"");

        // Mapeando a mensagem para o formato json
        String json = JsonFormat.printer().print(contatoAluno);

        // Escrita do conteúdo json em arquivo texto
        fos = new FileOutputStream(new File("aluno.json"));
        fos.write(json.getBytes());
        fos.close();
        System.out.println("Contato escrito em formato texto/json no arquivo \"aluno.json\"");
    }
}
