package br.pa.com.femabra.admin.backingbean;

import br.pa.com.femabra.admin.interact.LinkFather;
import br.pa.com.femabra.admin.interact.LinkSon;

import java.util.ArrayList;
import java.util.List;

public class PipeLineBackingBean {

    public List<LinkFather> getLinks(){

        List<LinkFather> links  = new ArrayList<>();
        List<LinkSon> linksSon1 = new ArrayList<>();
        linksSon1.add(new LinkSon("LINK 1 - 1"));
        linksSon1.add(new LinkSon("LINK 1 - 2"));
        linksSon1.add(new LinkSon("LINK 1 - 3"));
        linksSon1.add(new LinkSon("LINK 1 - 4"));
        links.add(new LinkFather("MAIN - 1", linksSon1));
        List<LinkSon> linksSon2 = new ArrayList<>();
        linksSon2.add(new LinkSon("LINK 2 - 1"));
        linksSon2.add(new LinkSon("LINK 2 - 2"));
        linksSon2.add(new LinkSon("LINK 2 - 3"));
        linksSon2.add(new   LinkSon("LINK 2 - 4"));
        linksSon2.add(new LinkSon("LINK 2 - 5"));
        links.add(new LinkFather("MAIN - 2",linksSon2));
        return links;

    }



}
