package CTTI;

/**
 * 
 * Clase que define un Entry (par key, value) de Strings
 * @author Accenture
 *
 */
public class MyEntry implements Comparable<MyEntry> {

	/** Valor en Base de datos */
    private String valueBBDD;
    /** Valor en memoria */
	private String value;
	/** key */
    private String key;
    
    /** System property */
    private boolean systemProperty = false; 

    /**
     * Constructor por defecto.
     * @param value
     * @param key
     */
    public MyEntry(String key, String value) {
    	super();
        this.value = value;
        this.key = key;
    }

    /**
     * Constructor por defecto
     */
    public MyEntry() {
    	super();
    	this.value = null;
    	this.key = null;
    }
    /**
     * Get Key
     * @return String
     */
    public String getKey() {
        return key;
    }

    /** 
     * Set Key
     * @param key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /** 
     * Get Value
     * @return String
     */
    public String getValue() {
        return value;
    }

    /**
     * Set value
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }
    
    /**
	 * @return the valueBBDD
	 */
	public String getValueBBDD() {
		return valueBBDD;
	}

	/**
	 * @param valueBBDD the valueBBDD to set
	 */
	public void setValueBBDD(String valueBBDD) {
		this.valueBBDD = valueBBDD;
	}

	/**
     * Get new Instance
     * @return MyEntry
     */
    public static MyEntry getInstance() {
    	return new MyEntry();
    }
    
    /**
	 * @return the systemProperty
	 */
	public boolean isSystemProperty() {
		return systemProperty;
	}

	/**
	 * @param systemProperty the systemProperty to set
	 */
	public void setSystemProperty(boolean systemProperty) {
		this.systemProperty = systemProperty;
	}

	/**
     * Get new Instance for key, value
     * @param key
     * @param value
     * @return MyEntry
     */
    public static MyEntry getInstance(String key, String value) {
    	return new MyEntry(key, value);
    }

	@Override
	public int compareTo(MyEntry o) {
		int resultCompare = 0; //Por defecto iguales
		if(o == null) {
			resultCompare = 1; //Si el otro no esta informado, soy más grande
		} else {
			if(getKey() == null) {
				if(o.getKey() == null) {
					resultCompare = 0;	//Mi key = null y la suya también, iguales
				} else {
					resultCompare = -1; //Mi key = null y la suya no, él es más grande
				}
			} else {
				if(o.getKey() == null) {
					resultCompare = 1; // Mi key no es null y la sula es null, soy más grande
				} else {
					resultCompare = getKey().compareTo(o.getKey()); //Comparamos keys no null como String 
					if(resultCompare == 0) { //Si las claves iguales
						if(getValue() == null) {
							if(o.getValue() == null) {
								resultCompare = 0; // Mi valor es null y el suyo también, iguales
							} else {
								resultCompare = -1; // Mi valor null y el suyo no, él es más grande
							}
						} else {
							if(o.getValue() == null) {
								resultCompare = 1; //Mi valor no es null y el suyo sí, yo soy más grande
							} else {
								resultCompare = getValue().compareTo(o.getValue()); //Si ningun valor es null, se comparan como strings
							}
						}
					}
				}
			}
		}
		return resultCompare;
	}
}

