package grace.bk.util;

import java.util.ArrayList;

public class MonoMultiList<T> extends ArrayList<T> {

	protected Class<?> protoClass = null; // Classe du prototype
	protected boolean isMono; // isMono est vrai si la liste est monomorphe

	public MonoMultiList(T proto) { // Le prototype est fixe e la creation, mais uniquement
		// par une instance, car sinon, on ne pourrait pas verifier que le type passe en 
		// parametre est un sous-type de T (impossibilite de Java 5 car T disparait e la
		// compilation par necessite de compatibilite)
		super();
        // TODO placer l'objet dans la liste et s'en servir comme prototype
        // DONE
        super.add(proto);
        protoClass = proto.getClass();
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
        // TODO si on est mode Monomorphe, verifier la coherence avec la classe prototype
        // TODO ne pas oublier de gerer le booleen (vrai si l'ajout s'est bien fait)

        /*
        dans multi on ajoute dans la liste si c'est mono et si la coherence est verifie
        entre la l'Objet (T) et la classe prototype
        Si c'est pas mono en
         */

        //return isMono && (getProtoClass() == t.getClass()) && super.add(t);

        //return !isMono || getProtoClass() == t.getClass() && super.add(t);

        if (isMono) { // Cas mono
            if ((getProtoClass() == t.getClass())) {
                return super.add(t);
            }
        } else { // Cas multi
            return super.add(t);
        }
        return false;
    }
	
}
