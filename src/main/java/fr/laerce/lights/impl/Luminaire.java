package fr.laerce.lights.impl;

import fr.laerce.lights.Eclairage;

import java.util.List;


/**
 * @author fred
 * 
 */
public class Luminaire implements Eclairage {

    private List<Eclairage> ampoules;

    public Luminaire() {

    }


    public void setAmpoules(List<Eclairage> ampoules) {
        this.ampoules = ampoules;
    }

    @Override
    public void allumer() {
        for (int i=0; i< this.ampoules.size();i++ ) {
            this.ampoules.get(i).allumer();
        }
   }

    @Override
    public void eteindre() {
        for(int i = 0; i< this.ampoules.size();i++){
            this.ampoules.get(i).eteindre();
        }
    }

    @Override
    public void intensifier() {
        for (int i = 0; i < ampoules.size(); i++) {
            this.ampoules.get(i).intensifier();
        }
    }

    @Override
    public void diminuer() {
        for(int i = 0; i < ampoules.size(); i++){
            this.ampoules.get(i).diminuer();
        }

    }

    /**
     * Retourne l'état du luminaire dans l'intervalle [0..10] ou -1 si il est en
     * panne. L'état résultant est la plus grande valeur des états des 4
     * ampoules du luminaire
     * 
     * @return l'état du luminaire
     */
    @Override
    public int etat() {
        int etat = -1;
        // version defensive
        if(ampoules.size()>0){
            String className = ampoules.get(0).getClass().getName();
            for(int i=1; i < ampoules.size(); i++){
                if(!ampoules.get(i).getClass().getName().equals(className)){
                    return -1;
                }
            }
        }
        for(int i = 0; i < ampoules.size(); i++){
            if(ampoules.get(i).etat() > etat){
                etat = ampoules.get(i).etat();
            }
        }
        return etat;
    }

    public String toString() {
        return "Classe : " + this.getClass().getName() + " etat :"
                + this.etat();
    }

}
