package Computador;

import HardwareBasico.HardwareBasico;
import MemoriaUSB.MemoriaUSB;
import SistemaOperacional.SistemaOperacional;

public class Computador {

    private String marca;
    private float preco;
    private MemoriaUSB memoriaUSB;
    private SistemaOperacional sistemaOperacional;
    private HardwareBasico[] HardwaresBasico;

    public Computador(String marca,  float preco) {
        this.marca = marca;
        this.preco = preco;
        setHardwaresBasicos(new HardwareBasico[3]);
    }

    public void setSistemaOperacional(SistemaOperacional sistemaOperacional){
        this.sistemaOperacional = sistemaOperacional;
    }

    public SistemaOperacional getSistemaOperacional(){
        return sistemaOperacional;
    }

    public void setHardwaresBasicos(HardwareBasico[] hardwaresBasicos){
        this.HardwaresBasico = hardwaresBasicos;
    }

    public HardwareBasico[] getHardwaresBasicos(){
        return HardwaresBasico;
    }

    public void setMemoriaUSB(MemoriaUSB memoriaUSB){
        this.memoriaUSB = memoriaUSB;
    }

    public void mostraPCConfigs() {
        System.out.println("====================================");
        System.out.println("PC da marca: " + this.marca);
        System.out.println("Preço: R$ " + this.preco);

        System.out.println("\n--- Hardware ---");
        if (HardwaresBasico != null) {
            for (HardwareBasico hb : HardwaresBasico) {
                if (hb != null) {
                    System.out.println(hb.getNome() + " - " + hb.getCapacidade());
                }
            }
        }

        System.out.println("\n--- Sistema Operacional ---");
        if (sistemaOperacional != null) {
            System.out.println(sistemaOperacional.getNome() + " (" + sistemaOperacional.getTipo() + " bits)");
        }

        System.out.println("\n--- Memória USB ---");
        if (memoriaUSB != null) {
            System.out.println(memoriaUSB.getNome() + " - " + memoriaUSB.getCapacidade() + " GB");
        }
        System.out.println("====================================\n");
    }

    public float getPreco() {
        return preco;
    }

}
