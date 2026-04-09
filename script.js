// 获取DOM元素
const avatarImg = document.getElementById('avatar-img');
const avatarUpload = document.getElementById('avatar-upload');
const nameInput = document.getElementById('name-input');
const nameDisplay = document.getElementById('name-display');
const bioInput = document.getElementById('bio-input');
const bioDisplay = document.getElementById('bio-display');
const saveBtn = document.getElementById('save-btn');

// 1. 头像上传事件（实时更换头像）
avatarUpload.addEventListener('change', (e) => {
    const file = e.target.files[0];
    if (file) {
        const reader = new FileReader();
        reader.onload = (event) => {
            avatarImg.src = event.target.result;
            localStorage.setItem('avatar', event.target.result);
        };
        reader.readAsDataURL(file);
    }
});

// 2. 保存按钮点击事件（表单验证+动态内容展示）
saveBtn.addEventListener('click', () => {
    // 表单验证：非空校验
    if (!nameInput.value.trim()) {
        alert('请输入姓名！');
        nameInput.focus();
        return;
    }
    if (!bioInput.value.trim()) {
        alert('请输入个人简介！');
        bioInput.focus();
        return;
    }

    // 动态内容展示：将输入内容显示到页面
    nameDisplay.textContent = nameInput.value;
    bioDisplay.textContent = bioInput.value;

    // 本地存储：刷新页面不丢失数据
    localStorage.setItem('name', nameInput.value);
    localStorage.setItem('bio', bioInput.value);

    // 保存后清空输入框
    nameInput.value = '';
    bioInput.value = '';

    alert('保存成功！');
});

// 3. 页面加载时，读取本地存储的内容（数据持久化）
window.addEventListener('load', () => {
    const savedAvatar = localStorage.getItem('avatar');
    const savedName = localStorage.getItem('name');
    const savedBio = localStorage.getItem('bio');

    if (savedAvatar) avatarImg.src = savedAvatar;
    if (savedName) nameDisplay.textContent = savedName;
    if (savedBio) bioDisplay.textContent = savedBio;
});
