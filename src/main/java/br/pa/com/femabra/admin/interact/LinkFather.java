package br.pa.com.femabra.admin.interact;

import java.util.List;

public class LinkFather {



    private String name;

    private List<LinkSon> sons;

    public LinkFather() {
    }

    public LinkFather(String name, List<LinkSon> sons) {
        this.name = name;
        this.sons = sons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LinkSon> getSons() {
        return sons;
    }

    public void setSons(List<LinkSon> sons) {
        this.sons = sons;
    }

}
