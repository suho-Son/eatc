import { useState } from 'react';
import './App.css';

function App() {
  // API 기본 경로
  const API_BASE = process.env.REACT_APP_API_BASE_URL || '/api';

  // 로그인 입력 폼 표시 여부
  const [showLogin, setShowLogin] = useState(false);
  // 아이디와 비밀번호 입력 값
  const [loginId, setLoginId] = useState('');
  const [password, setPassword] = useState('');
  // 발급 받은 토큰
  const [token, setToken] = useState('');

  // 로그인 버튼 클릭 시 폼을 보여 주도록 상태 변경
  const toggleLoginForm = () => {
    setShowLogin(!showLogin);
  };

  // 실제 로그인 처리
  const handleLogin = async () => {
    try {
      const response = await fetch(`${API_BASE}/login`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ loginId, password }),
      });
      if (response.ok) {
        const data = await response.json();
        alert('로그인 성공');
        setToken(data.token);
      } else {
        alert('로그인 실패');
      }
    } catch (err) {
      console.error(err);
      alert('오류 발생');
    } finally {
      // 로그인 후 입력값 초기화
      setLoginId('');
      setPassword('');
      setShowLogin(false);
    }
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

      {/* 발급된 토큰 표시 */}
      {token && (
        <pre>{`TOKEN: ${token}`}</pre>
      )}
    </div>
  );
}

export default App;
