# AVS TILES
TILES 

Le plug-in Tiles est maintenant mis en place.

Il permet au site d'avoir une organisation des pages.
Les styles du header, du footer, du menu et du body sont disponibles dans le repertoire /WebContent/jsp/tiles/ . Dedans sont disponibles :
- Le template.jsp pour l'organisation de la page.
- Le header.jsp et les autres parties de la page pour organiser les div.
 
Pour permettre à une jsp d'utiliser ce template il faut réaliser ces étapes :
- Créer votre jsp
- Aller dans WEB-INF tiles-defs.xml et ajouter ce bout de code : 
	<definition name="nomquevousvoulezdonner" extends="template">
		<put name="title" type="string" value="Title de votre page" />
		<put name="body" value="lien de vote jsp" />
	</definition>
- Lors de la déclaration de votre action dans le struts-config.xml, dans le path du formward ne plus mettre le lien de votre jsp mais le name 
  de la balise definition : nomquevousvoulezdonner .
  
Pour toute question, demandez à christian montois.