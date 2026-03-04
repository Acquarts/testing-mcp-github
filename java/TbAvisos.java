package CTTI;

import java.util.Date;

import javax.persistence.*;

/**
 * Entity para la tabla Avisos, destinada a almacenar el detalle de todos los avisos (alertes y tancaments)
 * que pueden ser presentados al usuario al ingresar las facturas
 * 
 * @author JASC
 *
 */
@Entity
@Table(name="AVISOS", schema = "sefac_adm")
@NamedQueries({
	@NamedQuery(name="TbAvisos.findAllAvisos",
			query="SELECT aviso FROM TbAvisos aviso" +
					"	ORDER BY aviso.idTipus DESC, aviso.dataInici DESC"),
			
	@NamedQuery(name="TbAvisos.findAvisosActivos",
			query="SELECT aviso FROM TbAvisos aviso " +			
				" WHERE (aviso.dataInici <= :fechaActiva) " +
				"		AND (aviso.dataFi IS NULL " +
				"				OR aviso.dataFi >= :fechaActiva) " +
				" 		AND (aviso.actiu = 'S')" +
				" ORDER BY aviso.idTipus DESC, aviso.dataInici DESC"),
				
	@NamedQuery(name="TbAvisos.findTancamentByDate",
			query="SELECT aviso FROM TbAvisos aviso " +
				" WHERE (aviso.dataInici <= :date) " +
				"		AND (aviso.dataFi IS NULL  " +
				"				OR aviso.dataFi >= :date) " +
				" 		AND (aviso.idTipus LIKE '%T%')"),
				
	@NamedQuery(name="TbAvisos.findTancamentActiuByDate",
			query="SELECT aviso FROM TbAvisos aviso " +			
				" WHERE (aviso.dataInici <= :fechaTancament) " +
				"		AND (aviso.dataFi IS NULL  " +
				"				OR aviso.dataFi >= :fechaTancament) " +
				" 		AND (aviso.idTipus LIKE '%T%') " +
				"		AND (aviso.actiu = 'S')"),	
				
	@NamedQuery(name="TbAvisos.findAllAlerts",
			query="SELECT aviso FROM TbAvisos aviso " +			
			" WHERE aviso.idTipus = 'A' " +
			" ORDER BY aviso.dataInici DESC"),
			
	@NamedQuery(name="TbAvisos.findAllTancaments",
			query="SELECT aviso FROM TbAvisos aviso " +			
			" WHERE aviso.idTipus = 'T' " +
			" ORDER BY aviso.dataInici DESC"),

		@NamedQuery(name="TbAvisos.findAllTancamentsPage",
				query="SELECT aviso FROM TbAvisos aviso " +
						" WHERE aviso.idTipus = 'T' " +
						" ORDER BY aviso.dataInici DESC"),
			
	@NamedQuery(name="TbAvisos.findSolapamientoConTancament",
			query="SELECT aviso FROM TbAvisos aviso " +			
			" WHERE aviso.idTipus = 'T' " +
			" 	AND aviso.id <> :id " +
			"	AND (" +
			"		(aviso.dataInici <= :dataInicial) AND (aviso.dataFi IS NULL  OR aviso.dataFi >= :dataInicial) " +
			"		OR (aviso.dataInici <= :dataFinal) AND (aviso.dataFi IS NULL  OR aviso.dataFi >= :dataFinal)" +
			"	) " +
			" ORDER BY aviso.dataAlta"),
			
	@NamedQuery(name="TbAvisos.findTancamentSinFechaFin",
			query="SELECT aviso FROM TbAvisos aviso " +			
				" WHERE aviso.idTipus = 'T' " +
				" 	AND aviso.id <> :id " +
				"	AND aviso.dataFi IS NULL")	
			
})
public class TbAvisos implements java.io.Serializable
{
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 20160118L;

	
	/**
	 * Clave primaria de la tabla
	 */	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "avisos_SEQ")
	@SequenceGenerator(name = "avisos_SEQ", 
			sequenceName = "sefac_adm.avisos_sequence",
            allocationSize = 1)
	@Column(name="id", 
			unique=true, 
			nullable=false)	
	private Integer id;
	
	/**
	 * A o T, indicando si es una Alerta o un Tancament
	 */
	@Column(name="id_tipus", 
			length = 1,
			nullable=false)
	private String idTipus;
	
	/**
	 * Nombre comlepto del tipo, es decir 'Alerta' o 'Tancament'
	 */
	@Column(name="desc_tipus",
			length = 10,
			nullable=false)
	private String descripcioTipus;
	
	/**
	 * Titulo descriptivo del aviso 
	 */
	@Column(name="titol",
			length = 50,
			nullable=false)
	private String titol;
	
	/**
	 * Descripcin detallada del motivo del aviso
	 */
	@Column(name="descripcio",
			length = 250, 
			nullable=false)
	private String descripcio;
	
	/**
	 * Fecha de inicio de cuando debe actiavrse el aviso
	 */
	@Column(name="data_inici",
			nullable=false)
	private Date dataInici;
	
	/**
	 * Fecha cuando debe finalizar el aviso
	 */
	@Column(name="data_fi",
			nullable=true)
	private Date dataFi;
	
	/**
	 * S/N, indicando si est acivo (S) o inactivo (N)
	 */
	@Column(name="actiu",
			length = 1,
			nullable=false)
	private String actiu;
	
	/**
	 * Usuario creador del aviso
	 */
	@Column(name="usuari_alta",
			length = 50,
			nullable=false)
	private String usuariAlta;
	
	/**
	 * Fecha cuando fue creado este aviso
	 */
	@Column(name="data_alta",
		nullable=false)
	private Date dataAlta;
		
	/**
	 * ltimo usuario que ha realizado alguna modificacin
	 * sobre este aviso
	 */
	@Column(name="usuari_modificacio",
			length = 50,
			nullable=false)
	private String usuariModificacio;
	
	/**
	 * Fecha de la ltima modificacin realizada sobre este aviso
	 */
	@Column(name="data_modificacio",
			nullable=false)
	private Date dataModificacio;

	
	
	/* 
	 * ------------------------------------
	 * Getters and Setters
	 * ------------------------------------ 
	 */

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String getTitol()
	{
		return titol;
	}

	public void setTitol(String titol)
	{
		this.titol = titol;
	}

	public String getDescripcio()
	{
		return descripcio;
	}

	public void setDescripcio(String descripcio)
	{
		this.descripcio = descripcio;
	}

	public Date getDataInici()
	{
		return dataInici;
	}

	public void setDataInici(Date dataInici)
	{
		this.dataInici = dataInici;
	}

	public Date getDataFi()
	{
		return dataFi;
	}

	public void setDataFi(Date dataFi)
	{
		this.dataFi = dataFi;
	}

	public String getActiu()
	{
		return actiu;
	}

	public void setActiu(String actiu)
	{
		this.actiu = actiu;
	}

	public String getUsuariAlta()
	{
		return usuariAlta;
	}

	public void setUsuariAlta(String usuariAlta)
	{
		this.usuariAlta = usuariAlta;
	}

	public Date getDataAlta()
	{
		return dataAlta;
	}

	public void setDataAlta(Date dataAlta)
	{
		this.dataAlta = dataAlta;
	}

	public String getUsuariModificacio()
	{
		return usuariModificacio;
	}

	public void setUsuariModificacio(String usuariModificacio)
	{
		this.usuariModificacio = usuariModificacio;
	}

	public Date getDataModificacio()
	{
		return dataModificacio;
	}

	public void setDataModificacio(Date dataModificacio)
	{
		this.dataModificacio = dataModificacio;
	}

	public String getIdTipus()
	{
		return idTipus;
	}

	public void setIdTipus(String idTipus)
	{
		this.idTipus = idTipus;
	}

	public String getDescripcioTipus()
	{
		return descripcioTipus;
	}

	public void setDescripcioTipus(String descripcioTipus)
	{
		this.descripcioTipus = descripcioTipus;
	}
	
	
	
}
