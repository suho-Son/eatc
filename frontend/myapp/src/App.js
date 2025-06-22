import { useState } from 'react';
import './App.css';

function App() {
  const [loginId, setLoginId] = useState('');
  const [password, setPassword] = useState('');
  const [user, setUser] = useState(null);

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch('/api/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({ loginId, password })
      });
      if (response.ok) {
        const data = await response.json();
        setUser(data);
      } else {
        alert('로그인 실패');
      }
    } catch (err) {
      console.error(err);
      alert('로그인 중 오류 발생');
    }
  };

  return (
    <div className="App">
      {user ? (
        <div>
          <h2>{user.name}님 환영합니다.</h2>
        </div>
      ) : (
        <form onSubmit={handleSubmit}>
          <div>
            <label>ID: </label>
            <input value={loginId} onChange={(e) => setLoginId(e.target.value)} />
          </div>
          <div>
            <label>PW: </label>
            <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
          </div>
          <button type="submit">로그인</button>
        </form>
      )}
    </div>
  );
}

export default App;
