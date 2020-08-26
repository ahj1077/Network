## 유니캐스트 (Unicast)
  
  
  특정 목적지의 주소 하나만을 가지고 통신하는 방식이다.
  
  보낼 프레임에 받는 pc의 맥 어드레스를 기재해 로컬 네트워크 상에 있는 모든 pc들에게 정보를 뿌리게 되는데,
  
  각 pc의 랜카드들은 해당 맥 어드레스를 보고 자기 것이 아니면 그대로 버리게 된다. 
  
  이것은 pc의 cpu에까지는 영향을 주지 않아 pc 성능이 저하되는 일은 발생하지 않는다.
  
  
## 브로드캐스트 (Broadcast)
  
  로컬 네트워크 상에 붙어있는 모든 네트워크 장비들에게 보내는 통신 방식
  
  이러한 로컬 네트워크를 **브로드캐스트 도메인** 이라고도 한다.
  
  브로드 캐스트의 주소는 맥어드레스로 했을 때 FFFF.FFFF.FFFF 이다. 이 주소가 오면 랜카드는 이 패킷을 CPU에 보내게 된다.
  
  때문에 과도한 브로드캐스트는 PC자체의 성능을 떨어뜨립니다.
  
  처음 두 PC간 통신을 하는 경우에 상대편의 맥어드레스를 모르는 상태이다. (IP는 알 수 있음) 이 경우에 상대의 맥 어드레스를
  
  알아내기 위해서 하는 동작이 ARP인데, 이 ARP가 바로 브로드캐스트이다.
  
  ARP는 "이 IP주소 가진 호스트 누구야?"하고 브로드캐스트를 보내며, 그 IP주소를 가진 호스트가 맥어드레스를 보내는 과정이다.
  
  이외에도 라우터끼리 정보를 교환한다거나 서버가 모든 클라이언트들에게 알릴 때 등 여러 경우에 사용합니다.
  
  
## 멀티캐스트 (Multicast)
  
  전체중에 일부에게만 정보를 보내는 통신 방식
  
  해당 멀티캐스트 채널에 속해있는 사람들에게만 선택적으로, 한번에 보낼 수 있다.
  
  하지만 라우터나 스위치에서 멀티캐스트 기능을 지원해야 쓸 수 있음
  
  

  
  
  
  

 