-- permet de lister les url et les droits associés

SELECT url, nom, description FROM profildroit prdr 
inner join profil p on p.id_Profil = prdr.id_Profil
inner join droit d on d.id_Droit = prdr.id_Droit
order by d.url, p.nom