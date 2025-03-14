package game.human;

public class HumanServiceImpl implements HumanService {

	@Override
	public HumanDTO getMember(HumanDTO humanDTO) {
		// TODO Auto-generated method stub
		
		HumanDAO dao = (HumanDAO) new HumanDAOImpl();
		humanDTO = dao.selectMember(humanDTO);
		
		return humanDTO;
	}
	
	
}
