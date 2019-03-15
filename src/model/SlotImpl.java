package model;

import model.enumeration.Color;
import model.interfaces.Slot;

public class SlotImpl implements Slot {

	private int slotPos;
	private Color slotColor;
	private int slotNum;
	public static final int WHEEL_SIZE = 38;
	
	public SlotImpl(int position, Color color, int number) {
		
		this.slotPos = position;
		this.slotColor = color;
		this.slotNum = number;
	}
	
	@Override
	public int getPosition()
	{
		
			return this.slotPos;	
	}

	@Override
	public int getNumber()
	{

		return this.slotNum;
	}

	@Override
	public Color getColor()
	{

		return this.slotColor;
	}

	@Override
	public boolean equals(Slot slot)
	{
		
		return false;
	}
	
	@Override
	public String toString() {
		return String.format("Position: %d, Color: %s, Number: %d", this.slotPos,this.slotColor,this.slotNum);
	}

}
