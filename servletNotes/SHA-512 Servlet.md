



<br>

1. loginWrapperSha.html 에서 LoginShaServlet.java 으로 넘어간다.



2. LoginShaServlet.java

```java
protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = request.getParameter("id");
		String pass = request.getParameter("pwd");
		String originPass = (String)request.getAttribute("originPwd");

		System.out.println(id + "/" + originPass + "/" + pass);
	}
```

최종적으로 id와 평문 비밀번호, 암호화된 비밀번호를 출력한다.

이를 위해 LoginShaServlet.java 에서 EncryptFilter.java 로 넘어간다.



3. EncryptFilter.java

```java
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
    	//사용가능한 매개변수 타입이 HttpServletRequest 이므로 
    	//originRequest로 request를 형 변환하여 참조한다.
		HttpServletRequest originRequest = (HttpServletRequest)request;
    
    	//평문 비밀번호를 저장하기 위한 작업.
		request.setAttribute("originPwd", request.getParameter("pwd"));
		
    	//암호화를 위해 EncryptWrapper 를 사용한다.
		EncryptWrapper ew = new EncryptWrapper(originRequest);
		
		//암호화된 결과를 LoginShaServlet 으로 다시 전달한다.
		chain.doFilter(ew, response);
	}
```



4. EncryptWrapper.java

```java
@Override
	public String getParameter(String name) {
		String result = null;
		if(name!=null && "pwd".equals(name)) {
			
			//result = 암호화 처리 된 값.
			result = getSha512(super.getParameter(name));
		}else {
			result = super.getParameter(name);
		}
		
		
		
		
		return result;
	}
	
	private String getSha512(String pwd) {
		try {
			MessageDigest md =  MessageDigest.getInstance("SHA-512");
			byte[] bytes = pwd.getBytes("UTF-8");
			md.update(bytes);
			return Base64.getEncoder().encodeToString(md.digest());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Sha 512 Error");
			e.printStackTrace();
			return null;
		}
		
	}
```







<br><hr>

























