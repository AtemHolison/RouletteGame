package model;

import model.enumeration.BetType;
import model.interfaces.Player;

public class SimplePlayer implements Player {
	
	private String id;
	private String name;
	private int point;
	private int bet;
	private BetType betType;
	
	public SimplePlayer(String playerID,String playerName, int initPoint) {
		this.id = playerID;
		this.name = playerName;
		this.point = initPoint;
	}

	@Override
	public String getPlayerName()
	{
		
		return this.name;
	}

	@Override
	public void setPlayerName(String playerName)
	{
		
		this.name = playerName;
		
	}

	@Override
	public int getPoints()
	{
		
		return this.point;
	}

	@Override
	public void setPoints(int points)
	{
		this.point = points;
		
	}

	@Override
	public String getPlayerId()
	{
		
		return this.id;
	}

	@Override
	public boolean setBet(int bet)
	{
		resetBet();
		if(bet > 0 && this.point > bet) {
			this.bet = bet;
			return true;
		}
		return false;
	}

	@Override
	public int getBet()
	{
		
		return this.bet;
	}

	@Override
	public void setBetType(BetType betType)
	{
		this.betType = betType;
		
	}

	@Override
	public BetType getBetType()
	{
		
		return this.betType;
	}

	@Override
	public void resetBet()
	{
		this.bet = 0;
		
	}
	
	@Override
	public String toString() {
		return String.format("Player: id=%s, name = %s, bet = %d, betType = %s, points = %d", 
				this.id,this.name,this.bet,this.betType,this.point);
		
	}

}
