package util;

import java.util.ArrayList;

public class MonoDynList extends ArrayList<Object> {

	protected Class protoClass;

	public MonoDynList(Class protoClass) {
		super();
		// TODO conserver le prototype
		
	}
	
	public MonoDynList(Object proto) {
		super();
		// TODO placer l'objet dans la liste et s'en servir comme prototype
		
	}
	
	public Class getProtoClass() {
		return protoClass;
	}
	
	public boolean add(Object t) {
		// TODO vérifier la cohérence avec la classe prototype
		// TODO ne pas oublier de gérer le booléen (vrai si l'ajout s'est bien fait)
		return true;
	}

}
