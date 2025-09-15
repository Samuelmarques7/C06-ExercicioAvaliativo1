package Main;

import Computador.Computador;
import HardwareBasico.HardwareBasico;
import MemoriaUSB.MemoriaUSB;
import SistemaOperacional.SistemaOperacional;
import Cliente.Cliente;
import ProcessarPedido.ProcessarPedido;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        MemoriaUSB memoria1 = new MemoriaUSB("Pen-drive",16);
        MemoriaUSB memoria2 = new MemoriaUSB("Pen-drive",32);
        MemoriaUSB memoria3 = new MemoriaUSB("HD Externo",1);

        SistemaOperacional sistemaOperacional1 = new SistemaOperacional("macOS Sequoia", 64);
        SistemaOperacional sistemaOperacional2 = new SistemaOperacional("Windows 8", 64);
        SistemaOperacional sistemaOperacional3 = new SistemaOperacional ("Windows 10",64);

        HardwareBasico hardwareBasico1 = new HardwareBasico("Pentium Core i3 (2200 Mhz), 8 Gb de Memoria Ram",500);
        HardwareBasico hardwareBasico2 = new HardwareBasico("Pentium Core i5 (3370 Mhz), 16 Gb de Memoria Ram",1);
        HardwareBasico hardwareBasico3 = new HardwareBasico("Pentium Core i7 (4500 Mhz), 32 Gb de Memoria Ram",2);

        Computador computador1 = new Computador("Apple",535);
        computador1.setSistemaOperacional(sistemaOperacional1);
        computador1.setHardwaresBasicos(new HardwareBasico[]{hardwareBasico1});
        computador1.setMemoriaUSB(memoria1);

        Computador computador2 = new Computador("Samsung",1769);
        computador2.setSistemaOperacional(sistemaOperacional2);
        computador2.setHardwaresBasicos(new HardwareBasico[]{hardwareBasico2});
        computador2.setMemoriaUSB(memoria2);

        Computador computador3 = new Computador("Dell",6213);
        computador3.setSistemaOperacional(sistemaOperacional3);
        computador3.setHardwaresBasicos(new HardwareBasico[]{hardwareBasico3});
        computador3.setMemoriaUSB(memoria3);

        Cliente cliente1 = new Cliente("Samuel Marques", "123.456.789-00");

        Scanner entrada = new Scanner(System.in);
        int opcao;

        System.out.println("Bem-vindo à PCMania!");
        System.out.println("Escolha no mínimo 2 computadores para finalizar a compra.");
        System.out.println("1 - Promoção Apple");
        System.out.println("2 - Promoção Samsung");
        System.out.println("3 - Promoção Dell");
        System.out.println("0 - Finalizar compra");

        do {
            System.out.print("\nDigite o código da promoção desejada (1,2,3) ou 0 para finalizar: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    cliente1.addComputador(computador1);
                    System.out.println("Promoção Apple adicionada!");
                    break;
                case 2:
                    cliente1.addComputador(computador2);
                    System.out.println("Promoção Samsung adicionada!");
                    break;
                case 3:
                    cliente1.addComputador(computador3);
                    System.out.println("Promoção Dell adicionada!");
                    break;
                case 0:
                    if (cliente1.getQuantidadeComputadores() < 2) {
                        System.out.println("Você precisa escolher pelo menos 2 computadores antes de finalizar!");
                    }
                    break;
                default:
                    System.out.println("Código inválido! Digite 1, 2, 3 ou 0 para finalizar.");
            }

        } while (opcao != 0 || cliente1.getQuantidadeComputadores() < 2);

        float total = cliente1.calculaTotalCompra();

        System.out.println("\n=========== RESUMO DA COMPRA ===========");
        System.out.println("Cliente: " + cliente1.getNome());
        System.out.println("CPF: " + cliente1.getCpf());

        for(Computador c : cliente1.getComputadores()){
            if(c != null) {
                c.mostraPCConfigs();
            }
        }

        System.out.println("Total da compra: R$ " + total);
        System.out.println("========================================");

        ProcessarPedido.enviarPedido(cliente1.getComputadores());
    }
}
