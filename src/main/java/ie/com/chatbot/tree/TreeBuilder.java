package ie.com.chatbot.tree;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ie.com.chatbot.action.IAction;

@Component
public class TreeBuilder {
	@Autowired
	private Map<String, IAction> actionMaps;
	@Autowired
	private List< IAction> listTemp;

	public Tree testTreeBuild() {
		TreeNode root = TreeNodeBuilder.aBuilder().addAction(actionMaps.get("MainMenu")).build();

		TreeNode child1 = TreeNodeBuilder.aBuilder().addAction(actionMaps.get("GenerateRecommender")).addParent(root)
				.build();
		TreeNode child2 = TreeNodeBuilder.aBuilder().addAction(actionMaps.get("ShowProfile")).addParent(root).build();
		

		TreeNode child1_1 = TreeNodeBuilder.aBuilder().addAction(actionMaps.get("Explain")).addParent(child1).build();
		TreeNode child1_2 = TreeNodeBuilder.aBuilder().addAction(actionMaps.get("GiveItemDetails")).addParent(child1)
				.build();
		
		TreeNode child1_1_1 = TreeNodeBuilder.aBuilder().addAction(actionMaps.get("GenerateRecommender")).addParent(child1_1).build();

//		TreeNode asd = TreeNodeBuilder.aBuilder().addAction(new BaseAction() {
//			@Override
//			public void _run(String[] input) {
//				System.out.println"bla bla");
//			}
//
//		}).addParent(child1).build();

		Tree tree = new Tree(root);
		return tree;
	}
}
