package com.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Main.printFizzBuzz();
        Main.getRareNotes(new int[]{1,1,2,2,2,2,5,4,5,9,2,3,3,12,4,4});
        Main.holdTheDoor(50, new int[]{10,25,500,5,100}, new int[]{2,3,1,2,90});
        Main.areAnagrams("Kylo Ren", "KN Lore Y");
    }

    /*
    Escreva um programa que imprima os números de 1 a 100. Mas para múltiplos de três
    imprima "Fizz" ao invés do número e para múltiplos de cinco imprima "Buzz".
    Para números múltiplos de três e cinco, imprima "FizzBuzz".
    */
    public static void printFizzBuzz() {
        for (int i = 1; i <= 100; i++) {
            if (((i % 3) == 0) && ((i % 5) == 0)) {
                System.out.println("FizzBuzz");
            } else if ((i % 3) == 0) {
                System.out.println("Fizz");
            } else if ((i % 5) == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

   /*
   Antes de Marvin, o andróide paranóico, ficar tão entediado e deprimido com a humanidade,
   ele era músico na Sirius Cibernetic Corporation. Um dia, ele decidiu descobrir as notas raras
   em todas as músicas já produzidas. Uma nota rara é aquela que aparece apenas uma vez em uma
   música específica. Como Marvin tem uma cabeça do tamanho de um planeta, ele sabe que
   levará apenas um nanossegundo para processar todas as músicas, mas os diodos em seu lado
   esquerdo estão com tanta dor que ele não quer escrever um programa que possa resolva isso
   e ele está esperando por você para fazer isso. Dado um int [] "notas" com todas as notas
   de uma música, retorna outro int [] com as raras notas presentes nessa música.
   Por exemplo, dada uma música com as notas {1, 2, 3, 2, 2, 1, 5, 5},
   seu método deve retornar {3}.
   Se não houver notas raras na música, seu método deve retornar nulo.
   */


    public static int[] getRareNotes(int[] notes) {
        List<Integer> notesList = Arrays.stream(notes).boxed().collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        for (Integer rareNote : notesList) {
            if ((Collections.frequency(notesList, rareNote) <= 1)) {
                result.add(rareNote);
            }
        }
        System.out.print(result);
        return notes;
    }

    /*
    Quando Hodor era adolescente, ele se interessou pela força das portas. Ele sabia o quão
    forte ele era e estava sempre tentando descobrir quanto tempo ele poderia manter uma
    porta fechada com uma horda de zumbis atrás dela tentando passar. Pelos seus cálculos,
    ele foi capaz de segurar zumbis "hodorStrength". Dada uma matriz "doorsStrength" com N
    portas e a quantidade de zumbis que cada porta pode conter sozinha e uma matriz
    "zombieInflux" com o número de zumbis que chegam em cada porta por segundo,
    devolva a porta que Hodor pode segurar por mais tempo antes de ser esmagado .
    Você tem a garantia de que ambas as matrizes têm o mesmo comprimento.
    Por exemplo, para uma entrada onde hodorStrength = 50, doorsStrength = {10,25,5} e
    zombiesInflux = {2,3,1}, a porta [0] seria mantida por 30 segundos, a porta [1]
    seria mantida por 25 segundos e a porta [2] seria mantida por 55 segundos.
    Portanto, a resposta neste caso é "2".
     */

    public static int holdTheDoor(int hodorStrength, int[] doorsStrength, int[] zombiesInflux) {
        if (doorsStrength.length != zombiesInflux.length) {
            return 0;
        }

        List<Integer> doorsStrengthList = Arrays.stream(doorsStrength).boxed().collect(Collectors.toList());
        List<Integer> zombiesInfluxList = Arrays.stream(zombiesInflux).boxed().collect(Collectors.toList());
        List<Integer> doors = new ArrayList<>();
        int i = 0;
        for (Integer doorStrength : doorsStrengthList) {
            int doorAndHodorPower = hodorStrength + doorStrength;
            Integer zombieInFlux = zombiesInfluxList.get(i);
            int timeDoorResist = doorAndHodorPower / zombieInFlux;
            doors.add(timeDoorResist);
            i++;
        }
        int door = doors.indexOf(Collections.max(doors));
        System.out.print(door);

        return door;
    }

    /*
    Desde que Kylo Ren descobriu que seu nome era um anagrama para Ken Rylo (que era o
    cachorro da família), ele ficou obcecado por anagramas. Como ele não era o garoto
    mais inteligente, ele pediu a um renomado programador Sith (você!) Para escrever um
    código que pudesse verificar se duas palavras eram anagramas. Duas palavras são
    consideradas anagramas se consistirem nos mesmos caracteres, mesmo que em um ordem
    diferente. Portanto, "ACT" é um anagrama para "CAT" e para "ACT" em si, mas não
    para "TACT". Seu método deve ser insensível a maiúsculas e minúsculas e deve
    ignorar espaços em branco ("Kylo Ren" e "KN Lore Y" devem ser considerados anagramas )
    */

    public static boolean areAnagrams(String word1, String word2) {
        if (word1.replace(" ", "").length() !=
                word2.replace(" ", "").length()) {
            System.out.println(false);
            return false;
        }
        char[] a1 = word1.replace(" ", "").toLowerCase().toCharArray();
        char[] a2 = word2.replace(" ", "").toLowerCase().toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        System.out.println(Arrays.equals(a1, a2));
        return Arrays.equals(a1, a2);
    }

    /*
    Estou tendo problemas para encontrar o melhor candidato com base nos resultados dos testes.
    Para cada questão respondida, decidi por uma pontuação (0, 0,5 ou 1,0). Eu tenho três
    tabelas no banco de dados: candidato, teste e question_score. A tabela de candidatos possui
    duas colunas: candidate_id e nome. A tabela de teste possui 2 colunas: test_id e nome.
    A tabela question_score tem 4 colunas: question_id, candidate_id, test_id e score, com
    candidate_id sendo um FK para a tabela de candidatos e test_id é um FK para a tabela de
    teste. Preciso de uma consulta SQL que retorne o nome do candidato e sua pontuação total,
    ordenada do melhor candidato (pontuação maior) ao pior, para todos os candidatos que
    responderam ao teste denominado "backend Java".
     */
    /*
    Tables: candidate(candidate_id, name), test(test_id, name),
    question_score(question_id, candidate_id, test_id, score)
     */
    /*
        SELECT c.name, q.score FROM question_score q
        INNER JOIN candidate c ON q.candidate_id = c.candidate_id
        INNER JOIN test t ON q.test_id = t.test_id
        WHERE t.name = 'Java backend'
        ORDER BY q.score DESC;
     */

}