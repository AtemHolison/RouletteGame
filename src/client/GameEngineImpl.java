package client;

import java.util.Collection;

import model.enumeration.BetType;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.Slot;
import view.interfaces.GameEngineCallback;

public class GameEngineImpl implements GameEngine {

	@Override
	public void spin(int initialDelay, int finalDelay, int delayIncrement)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calculateResult(Slot winningSlot)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void addPlayer(Player player)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Player getPlayer(String id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removePlayer(Player player)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Player> getAllPlayers()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean placeBet(Player player, int bet, BetType betType)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Slot> getWheelSlots()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
