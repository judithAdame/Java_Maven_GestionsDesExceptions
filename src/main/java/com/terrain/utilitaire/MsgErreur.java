package com.terrain.utilitaire;

/**
 *
 * @author 1895648
 */
public class MsgErreur {
  public static final String MSG_LOT_DESCRIPTION = "La description ne doit pas être vide!";
  public static final String MSG_LOT_NBSERVICES = "Le nombre de services n'est pas entre 0 et 5 inclusivement!";
  public static final String MSG_LOT_NBDROITP = "Le nombre de droits de passage n'est pas entre 0 et 10 inclusivement !";
  public static final String MSG_LOT_SUPERFICIE = "La superficie ne doit pas être ni négative, ni supérieur a 50000";
  public static final String MSG_TERRAIN_TYPE = "Le type de terrain n'est pas entre les valeurs 0,1 et 2!";
  public static final String MSG_TERRAIN_PMAX = "Un montant d'argent ne doit pas être négatif!";
  public static final String MSG_TERRAIN_PMIN = "Un montant d'argent ne doit pas être négatif!";
  public static final String MSG_TERRAIN_NBLOTS = "Le nombre de lots ne doit jamais dépasser 10 lots!";
  public static final String MSG_TERRAIN_NULLLOTS = "Un terrain doit avoir au moins un lot!";
  public static final String MSG_TERRAIN_DESCRIPTIONUNIQUE = "La description de chaque lot doit être unique!";
  public static final String MSG_LOT_DMESURE = "La date n'est pas enformat ISO-8601";
  public static final String MSG_PARSECURRENCY =  "Le montant ne peut pas etre negatif";
  public static final String MSG_NUMBERFORMAT =  "Erreur dans le type de donnée";
  public static final String MSG_JSON_PROPRIETES = "Il manque une proprieté";
}
