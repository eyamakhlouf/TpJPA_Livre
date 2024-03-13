package com.eya.test;
import com.eya.dao.LivreDao;
import com.eya.entities.Livre;
public class LivreTest {
public static void main(String[] args) {
//créer un objet client
Livre l = new Livre();
l.setTitre_livre("les miserebles");
l.setAuteur("victor hugo");
l.setPrix(120);
l.setGenre("Drame");
l.setNb_pages(200);

//ajouter l'objet client à la BD
LivreDao livDao = new LivreDao();
livDao.ajouter(l);
System.out.println("Appel de la méthode listerTous");
for (Livre li : livDao.listerTous())
System.out.println(li.getTitre_livre()+" "+li.getAuteur()+" "+li.getPrix()+" "+li.getGenre()+" "+li.getNb_pages());
System.out.println("Appel de la méthode listerParNom");
for (Livre li : livDao.listerParTitre_Livre("les"))

System.out.println(li.getTitre_livre()+" "+li.getAuteur()+" "+li.getPrix()+" "+li.getGenre()+" "+li.getNb_pages());

//tester les autres méthodes de la classe ClientDao
Livre LivreaModifier =livDao.listerParTitre_Livre("les miserebles").get(0);

// Modification du livre récupéré
if (LivreaModifier != null) {
	LivreaModifier.setTitre_livre("causette");
	livDao.modifier(LivreaModifier);
    System.out.println("Livre modifié avec succès");
} else {
    System.out.println("Livre avec le nom spécifié non trouvé");
}


System.out.println("Appel de la méthode listerTous après modification :");
for (Livre li : livDao.listerTous())
	System.out.println(li.getTitre_livre()+" "+li.getAuteur()+" "+li.getPrix()+" "+li.getGenre()+" "+li.getNb_pages());




Livre livreToDelete = livDao.consulter(l, 11); // Get the Livre entity to delete
livDao.supprimer(livreToDelete); // Delete the Livre entity


//tester les autres méthodes de la classe ClientDao
//tester la méthode modifier
/*l.setPrix(1200);
livDao.modifier(l);*/
//Consulter un étudiant
/*Livre livreConsulte = livDao.consulter(l, l.getIdLivre());
System.out.println("Livre consulté : " + livreConsulte.getTitre_livre() + " " + livreConsulte.getAuteur());*/
//tester la méthode supprimer
//livDao.supprimer(l);


}}
