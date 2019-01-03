package ie.com.chatbot.action;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import ie.com.chatbot.domain.UserInput;
import ie.com.chatbot.tree.TreeNode;

@Component("GiveItemDetails")
public class GivenItemDetails extends BaseAction {
	@Override
	public void _run(UserInput input) {
		String title = input.getParemeters().get(0);
		String msg = conversion.getUserCurrentChat(input.getUserId()).getCurrentRecommendation().getDetails()
				.get(title.equals("PM") ? 0 : 1);
		System.out.println(msg);
	}
	
	public boolean validateParemeter(TreeNode node, UserInput input) {				
		if (CollectionUtils.isEmpty(input.getParemeters())) {
			System.out.println("Please enter job title");
			return false;
		}
		return true;
	}
}
