/**
 * Created by Thomas on 21/05/2015.
 */


import java.sql.Connection;


public abstract class DAO<T> {
    protected Connection connect = null;

    public DAO(Connection connect){
        this.connect=connect;
    }

    /**
     * M�thode de cr�ation
     * @param obj
     * @return T
     */
    public abstract T create(T obj);

    /**
     * M�thode pour effacer
     * @param obj
     * @return T
     */
    public abstract T delete(T obj);

    /**
     * M�thode de mise � jour
     * @param obj
     * @return T
     */
    public abstract T update(T obj);

    /**
     * M�thode de recherche des informations avec son id
     * @param id
     * @return T
     */

// Seront redifinis plus en detail dans les classes filles
    //public abstract T find(int id);
    /**
     * M�thode de recherche des informations avec son libelle
     * @param libelle
     * @return T
     */
   // public abstract T find(String libelle);

}