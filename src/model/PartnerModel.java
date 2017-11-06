package model;

import java.util.ArrayList;
import javax.swing.AbstractListModel;
import model.Partner;

public class PartnerModel extends AbstractListModel {

    private ArrayList<Partner> partner = new ArrayList<Partner>();

    public PartnerModel() {
        this.partner.add(new Partner("a", "teszt"));
    }
    

    public void addPartner(String name, String addr) {
        partner.add(new Partner( name,addr));
    }

    @Override
    public int getSize() {
        return partner.size();
    }

    @Override
    public String getElementAt(int index) {
        return partner.get(index).toString();
    }
  
}
