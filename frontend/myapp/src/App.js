import { useEffect, useState } from 'react';
import './App.css';

/**
 * 사용자 목록을 출력하는 간단한 컴포넌트
 */
function App() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    fetch('http://192.168.0.121:8080/api/users')
      .then((res) => res.json())
      .then((data) => setUsers(data))
      .catch((err) => console.error('사용자 정보 조회 실패', err));
  }, []);

  return (
    <div className="App">
      <h1>사용자 목록</h1>
      <ul>
        {users.map((user) => (
          <li key={user.userId} data-testid="user-item">
            {user.name} ({user.loginId})
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;