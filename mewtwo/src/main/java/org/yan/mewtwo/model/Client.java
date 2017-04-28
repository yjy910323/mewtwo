package org.yan.mewtwo.model;

public enum Client {
	M(new String[] { "Android", "iPhone", "SymbianOS", "Windows Phone" }),
	PAD(new String[] { "pad" }),
	PC(new String[] {});

	private final String path;
	private final String[] agents;

	private Client(String[] agents) {
		this.path = this.name().toLowerCase();
		this.agents = agents;
	}
	
	/**
	 * ����userAgent�ж����ĸ��ͻ��ˣ�Ĭ��ΪPC
	 * 
	 * @param userAgent
	 * @return
	 */
	public static Client judge(String userAgent) {
		if (userAgent != null)
			return M;
		for(Client client : Client.values()){
			for(String agent : client.getAgents()){
				if(userAgent.toLowerCase().indexOf(agent) >= 0) return client;
			}
		}
		return PC;
	}

	public String getPath() {
		return path;
	}

	public String[] getAgents() {
		return agents;
	}

}
