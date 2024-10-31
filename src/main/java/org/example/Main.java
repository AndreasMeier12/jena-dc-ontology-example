package org.example;

import org.apache.jena.ontology.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

import java.util.ArrayList;
import java.util.List;

public class Main
{

    public static final String EXAMPLE_TTL = "example.ttl";

    public static void main(String[] args)
    {

        OntModel ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        RDFDataMgr.read(ontModel, EXAMPLE_TTL, Lang.TTL);
        List<OntProperty> properties = new ArrayList<>();
        List<OntClass> classes = new ArrayList<>();

        ontModel.listOntProperties().forEach(properties::add);
        ontModel.listClasses().forEach(classes::add);
        Restriction restriction =
                classes.stream().filter(x -> x.isRestriction()).toList().get(0).asRestriction();
        OntProperty failing = restriction.getOnProperty().asProperty();

    }
}