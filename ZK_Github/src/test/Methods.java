package test;

import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;


public class Methods extends GenericForwardComposer {
	Textbox txtUsername;
	Textbox txtPassword;
	Window wnd;


  	public void onClick$btnSubmit() throws InterruptedException	{
  		
  		Messagebox.show("Brukernavnet ditt er "+ txtUsername.getText() + " og passordet er " + txtPassword.getText());
  	}
}