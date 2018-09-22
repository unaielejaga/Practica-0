
public class Coche {
	
	private double miVelocidad; // Velocidad en pixels/segundo
	protected double miDireccionActual; // Direcci�n en la que estoy mirando en grados (de 0 a 360)
	protected double posX; // Posici�n en X (horizontal)
	protected double posY; // Posici�n en Y (vertical)
	private String piloto; // Nombre de piloto
	
	
	public double getMiVelocidad() {
		return miVelocidad;
	}
	public void setMiVelocidad(double miVelocidad) {
		this.miVelocidad = miVelocidad;
	}
	public double getMiDireccionActual() {
		return miDireccionActual;
	}
	public void setMiDireccionActual(double miDireccionActual) {
		this.miDireccionActual = miDireccionActual;
	}
	public double getPosX() {
		return posX;
	}
	public void setPosX(double posX) {
		this.posX = posX;
	}
	public double getPosY() {
		return posY;
	}
	public void setPosY(double posY) {
		this.posY = posY;
	}
	public String getPiloto() {
		return piloto;
	}
	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}

	public Coche() {
		this.miVelocidad = 0;
		this.miDireccionActual = 0;
		this.posX = 0;
		this.posY = 0;
		this.piloto = "";
	}
	
	public Coche(double miVelocidad, double miDireccionActual, double posX, double posY, String piloto ) {
		this.miVelocidad = miVelocidad;
		this.miDireccionActual = miDireccionActual;
		this.posX = posX;
		this.posY = posY;
		this.piloto = piloto;
	}
	
	public String toString() {
		return "Velocidad: " + -this.miVelocidad + "\n" + "Direccion: " + this.miDireccionActual + "\n" + "Pos. X: " + this.posX + "\n" + "pos. Y: " + this.posY + "\n" + "Piloto: " + this.piloto ;
	}
	
	 /** Cambia la velocidad actual del coche
	 * @param aceleracion Incremento de la velocidad en pixels/segundo
	 */
	 public void acelera( double aceleracion ) {
		 this.miVelocidad = this.miVelocidad + aceleracion;
	 }
	 /** Cambia la direcci�n actual del coche
	 * @param giro Angulo de giro a sumar o restar de la direcci�n actual, en grados (-180 a +180)
	 */
	 public void gira( double giro ) {
		 this.miDireccionActual = this.miDireccionActual + giro;
	 }
	 /** Cambia la posici�n del coche dependiendo de su velocidad y direcci�n
	 * @param tiempoDeMovimiento Tiempo transcurrido, en segundos
	 */
	 public void mueve() {
		 this.posX =  this.posX + this.miVelocidad *  Math.cos(this.miDireccionActual + (Math.PI / 2));
		 this.posY = this.posY + this.miVelocidad *  Math.sin(this.miDireccionActual + (Math.PI / 2));
	 } 
	
}
