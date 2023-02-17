package gyruda;

public class Card {
	private int power;
	private boolean isClone;
	private boolean isNonlegendaryClone;
	private boolean isPseudoClone;
	private boolean isKolaghan;
	public Card (int power, boolean isClone, boolean isNonlegendaryClone, boolean isPseudoClone, boolean isKolaghan) {
		this.power = power;
		this.isClone = isClone;
		this.isNonlegendaryClone = isNonlegendaryClone;
		this.isPseudoClone = isPseudoClone;
		this.isKolaghan = isKolaghan;
	}
	
	public int getPower() {
		return power;
	}
	public boolean getIsClone() {
		return isClone;
	}
	public boolean getIsNonlegendaryClone() {
		return isNonlegendaryClone;
	}
	public boolean getIsPseudoClone() {
		return isPseudoClone;
	}
	public boolean getIsKolaghan() {
		return isKolaghan;
	}
	public String toString() {
		return power + " " + isClone + " " + isNonlegendaryClone + " " +  isPseudoClone + " " + isKolaghan;
	}
}
