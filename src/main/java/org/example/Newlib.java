package org.example;

import org.apache.jena.ontapi.OntModelFactory;
import org.apache.jena.ontapi.OntSpecification;
import org.apache.jena.ontapi.model.OntStatement;
import org.apache.jena.ontology.OntProperty;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.vocabulary.RDFS;

import java.util.ArrayList;
import java.util.List;

import static org.example.Main.EXAMPLE_TTL;

public class Newlib
{

    public static void main(String[] args)
    {
        org.apache.jena.ontapi.model.OntModel ontModel = OntModelFactory.createModel(
                OntSpecification.OWL1_DL_MEM);
        RDFDataMgr.read(ontModel, EXAMPLE_TTL, Lang.TTL);
        List<org.apache.jena.ontapi.model.OntClass.Named> classes = ontModel.classes().toList();
        List<org.apache.jena.ontapi.model.OntProperty> props = ontModel.properties().toList();
        List<OntStatement> subClassStatements = classes.get(0).statements(RDFS.subClassOf).toList();

        System.out.println("done");
    }
}
