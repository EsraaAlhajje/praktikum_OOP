package gui.guiStaedtischeEinrichtungen;

import business.BuergeraemterModel;
import business.sporthallen.SporthalleModel;
import gui.guiBuergeraemter.BuergeraemterView;
import javafx.stage.Stage;
import ownUtil.ConcreteObserver;


public class StaedtischeEinrichtungenControl implements ConcreteObserver {
	
	private StaedtischeEinrichtungenView staedtischeEinrichtungenView;
	private BuergeraemterModel buergeraemterModel;
	private SporthalleModel sporthalleModel;

	public StaedtischeEinrichtungenControl(Stage primaryStage){
		
		
		this.buergeraemterModel = BuergeraemterModel.getInstanz();
		this.sporthalleModel = SporthalleModel.getInstance();
		
		
		
		
		
		this.staedtischeEinrichtungenView = new StaedtischeEinrichtungenView(this, 
			primaryStage,buergeraemterModel, sporthalleModel);
		buergeraemterModel.addObserver(this);
		sporthalleModel.addObserver(this);
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		staedtischeEinrichtungenView.zeigeBuergeraemterAn();

		
	}
}
	
	
