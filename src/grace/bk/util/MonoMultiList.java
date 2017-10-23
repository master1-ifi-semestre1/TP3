package util;

import java.util.ArrayList;

public class MonoMultiList<T> extends ArrayList<T> {

	protected Class<?> protoClass = null; // Classe du prototype
	protected boolean isMono; // isMono est vrai si la liste est monomorphe

	public MonoMultiList(T proto) { // Le prototype est fixé à la création, mais uniquement
		// par une instance, car sinon, on ne pourrait pas vérifier que le type passé en 
		// paramètre est un sous-type de T (impossibilité de Java 5 car T disparait à la
		// compilation par nécessité de compatibilité)
		super();
        // TODO placer l'objet dans la liste et s'en servir comme prototype		
		isMono = true;  // liste monomorphe stricte
	}
	
	public MonoMultiList() {
		super();
		isMono = false; // autorise le polymorphisme
	}
	
	public Class<?> getProtoClass() {
		return protoClass;
	}
	
	public boolean add(T t) {
		// TODO si on est mode Monomorphe, vérifier la cohérence avec la classe prototype
		// TODO ne pas oublier de gérer le booléen (vrai si l'ajout s'est bien fait)
		return true;
	}
	
}
