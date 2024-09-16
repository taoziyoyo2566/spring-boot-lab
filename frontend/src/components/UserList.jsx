import React, { useEffect, useState } from 'react';
import axios from 'axios';

// 设置 Axios 的默认基准 URL
// axios.defaults.baseURL = 'http://154.23.243.155:8082';
axios.defaults.baseURL = process.env.REACT_APP_API_BASE_URL
function UserList() {
    const [users, setUsers] = useState([]); // 存储用户列表
    const [loading, setLoading] = useState(true); // 加载状态
    const [error, setError] = useState(null); // 错误信息

    console.log("api getway url" + process.env.REACT_APP_API_BASE_URL);
    useEffect(() => {
        (async () => {
            if (process.env.NODE_ENV === 'development') {
                console.log('开发环境');
            } else if (process.env.NODE_ENV === 'production') {
                console.log('生产环境');
            }
            try {
                const response = await axios.get('/users'); // 请求后端 API
                setUsers(response.data); // 设置用户列表数据
            } catch (err) {
                setError(err.message || '未知错误'); // 设置错误信息
            } finally {
                setLoading(false); // 请求完成，设置加载状态为 false
            }
        })();
    }, []); // 仅在组件挂载时执行一次

    // 处理加载状态
    if (loading) {
        return <div>正在加载...</div>;
    }

    // 处理错误状态
    if (error) {
        return <div>发生错误：{error}</div>;
    }

    // 渲染用户列表
    return (
        <div>
            <h2>用户列表</h2>
            {users.length === 0 ? (
                <div>没有用户数据。</div>
            ) : (
                <ul>
                    {users.map((user) => (
                        <li key={user.id}>
                            姓名：{user.name}，邮箱：{user.email}
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
}

export default UserList;