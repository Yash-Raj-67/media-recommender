# Initialize Git Repository
git init -b main

# Create .gitignore
$gitignore = @("target/", "__pycache__/", "*.class", ".DS_Store", ".vscode/", ".idea/")
$gitignore | Out-File .gitignore -Encoding utf8

# Add files
git add .

# Commit
git commit -m "Initial commit: Multi-Stack Media Recommender"

Write-Host "--------------------------------------------------------"
Write-Host "Git repository initialized and files committed."
Write-Host "To push to GitHub, run:"
Write-Host "  git remote add origin https://github.com/<YOUR_USERNAME>/<REPO_NAME>.git"
Write-Host "  git push -u origin main"
Write-Host "--------------------------------------------------------"
