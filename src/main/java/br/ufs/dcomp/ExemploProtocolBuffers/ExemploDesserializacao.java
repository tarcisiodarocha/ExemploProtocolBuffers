package br.ufs.dcomp.ExemploProtocolBuffers;

import java.io.FileInputStream;
import java.io.File;
import java.util.List;
import com.google.protobuf.util.JsonFormat;

public class ExemploDesserializacao {
    public static void main(String[] args) throws Exception {
        // Obtendo bytes do arquivo
        File file = new File("aluno.bin");
        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        fis.read(buffer);
        fis.close();

        // Mapeando bytes para a mensagem protobuf
        ContatoProto.Aluno contatoAluno = ContatoProto.Aluno.parseFrom(buffer);

        // Extraindo dados da mensagem
        int matricula = contatoAluno.getMatricula();
        String nome = contatoAluno.getNome();
        String email = contatoAluno.getEmail();

        System.out.println(matricula);
        System.out.println(nome);
        System.out.println(email);

        // Extraindo a lista de telefones
        List<ContatoProto.Telefone> telefones = contatoAluno.getTelefonesList();
        for (ContatoProto.Telefone fone : telefones) {
            String numero = fone.getNumero();
            System.out.println(numero);
        }
    }
}
