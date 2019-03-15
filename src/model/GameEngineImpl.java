package model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;


import model.enumeration.BetType;
import model.enumeration.Color;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.Slot;
import view.interfaces.GameEngineCallback;

public class GameEngineImpl implements GameEngine {
	
	private List<Player> players;
	private List<Slot> slots;
	private List<GameEngineCallback> callBacks;
	
	
	
	public GameEngineImpl() {
		this.players = new ArrayList<Player>();
		this.slots = new ArrayList<Slot>();
		this.callBacks = new ArrayList<GameEngineCallback>();
		
		
		this.getSlots();
	}
	
	@Override
	public void spin(int initialDelay, int finalDelay, int delayIncrement)
	{
		Random rand = new Random();
		
		//create a random index to be passed to the slot collection and create a random slot
		int x = rand.nextInt(this.slots.size());
		Slot randomSlot = this.slots.get(x);
		int j = getIndexPos(randomSlot);
		
		//to start spinning the wheel the delayIncrement must be equal to the initialDelay
		int delay = initialDelay;
		while(delay < finalDelay) {
			j++;
			if(j == this.slots.size()) {
				j=0;
			}
			this.callBacks.get(0).nextSlot(this.slots.get(j), this);
			delay += delayIncrement;
		}
		
		Slot winningSlot = this.slots.get(j);
		this.callBacks.get(0).result(winningSlot, this);
	}

	//private method to get the index of a slot on the wheel
	private int getIndexPos(Slot slot) {
		
		return this.slots.indexOf(slot);
	}
	
	@Override
	public void calculateResult(Slot winningSlot)
	{
		for(Player player : this.players) {
			player.getBetType().applyWinLoss(player, winningSlot);;
		}
		
	}

	@Override
	public void addPlayer(Player player)
	{
		String playerId = player.getPlayerId();
		
		// find if there is a player with same id
		// and replace in the game list of player 
		for(int i = 0; i < this.players.size(); i++) {
			if(this.players.get(i).getPlayerId() == playerId) {
				this.players.set(i, player);
				return;
			}
		}
		
		this.players.add(player);
		return;
	}

	@Override
	public Player getPlayer(String id)
	{
		for(Player player : this.players) {
			if(id.equals(player.getPlayerId())) {
				return player;
			}	
		}
		return null;
	}

	@Override
	public boolean removePlayer(Player player)
	{
		for(int i = 0; i < this.players.size(); i++) {
			if(player.getPlayerId().equals(this.players.get(i).getPlayerId())) {
				this.players.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback)
	{
		this.callBacks.add(gameEngineCallback);
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback)
	{
		int index = this.callBacks.indexOf(gameEngineCallback);
		
		if(index != -1) {
			this.callBacks.remove(index);
			return true;
		}
		
		return false;
	}

	@Override
	public Collection<Player> getAllPlayers()
	{
		Collection<Player> allPlayers = new ArrayList<Player>();
		
		for(Player player : this.players) {
			allPlayers.add(player);
		}
		
		return allPlayers;
	}

	@Override
	public boolean placeBet(Player player, int bet, BetType betType)
	{
		player.setBet(bet);
		player.setBetType(betType);
		if(player.getBet() > 0 && player.getPoints() > player.getBet()) {
		return true;
		}
		return false;
	}

	@Override
	public Collection<Slot> getWheelSlots()
	{
		Collection<Slot> allSlots = new ArrayList<Slot>();
		
		for(Slot slot : this.slots) {
			allSlots.add(slot);
		}
		
		return allSlots;
		
	}

	//private method to print slots on wheel
	private void getSlots() {
		Color c;
		int [] nums = {00,27,10,25,29,12,8,19,31,18,6,21,33,16,4,23,35,14,2,0,28,9,26,30,11,7,20,32,17,5,22,34,15,3,24,36,13,1};
		for(int i=0;i<nums.length;i++) {
			if(i==0) {
				c = Color.GREEN00;
			}
			else if(i == 19) {
				c = Color.GREEN0;
			}
			else if(i%2==0) {
				c = Color.BLACK;
			}
			else {
				c = Color.RED;
			}
			Slot s = new SlotImpl(i,c,nums[i]);
			this.slots.add(s);
		}
	}
	
	
}
