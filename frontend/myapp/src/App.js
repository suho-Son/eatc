import { useState } from 'react';
import './App.css';

function App() {
  // 로그인 입력 폼 표시 여부
  const [showLogin, setShowLogin] = useState(false);
  // 아이디와 비밀번호 입력 값
  const [loginId, setLoginId] = useState('');
  const [password, setPassword] = useState('');

  // 로그인 버튼 클릭 시 폼을 보여 주도록 상태 변경
  const toggleLoginForm = () => {
    setShowLogin(!showLogin);
  };

  // 실제 로그인 처리(예시로 alert 사용)
  const handleLogin = () => {
    alert(`아이디: ${loginId}, 비밀번호: ${password}`);
    // 로그인 후 입력값 초기화
    setLoginId('');
    setPassword('');
    setShowLogin(false);
  };

  return (
    <div className="App">
      {/* 로그인 폼 토글 버튼 */}
      <button onClick={toggleLoginForm}>로그인</button>

      {/* 로그인 폼 */}
      {showLogin && (
        <div>
          <div>
            <input
              type="text"
              placeholder="아이디"
              value={loginId}
              onChange={(e) => setLoginId(e.target.value)}
            />
          </div>
          <div>
            <input
              type="password"
              placeholder="비밀번호"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
          </div>
          <button onClick={handleLogin}>로그인하기</button>
        </div>
      )}
    </div>
  );
}

export default App;
