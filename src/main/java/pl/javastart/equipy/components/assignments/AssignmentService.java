package pl.javastart.equipy.components.assignments;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.javastart.equipy.components.inventory.asset.Asset;
import pl.javastart.equipy.components.inventory.asset.AssetRepository;
import pl.javastart.equipy.user.User;
import pl.javastart.equipy.user.UserRepository;

import java.util.Optional;

@AllArgsConstructor
@Service
public class AssignmentService {

    private AssignmentRepository assignmentRepository;
    private UserRepository userRepository;
    private AssetRepository assetRepository;

    AssignmentDto createAssignment(AssignmentDto assignmentDto) {
        Long assetId = assignmentDto.getAssetId();
        Long userId = assignmentDto.getUserId();
        Optional<Assignment> activeAssigmnmentForAsset = assignmentRepository
                .findByAsset_IdAndEndIsNull(assetId);
        activeAssigmnmentForAsset.ifPresent(a -> {
            throw new InvalidAssignmentException("To wyposażenie jest aktualnie do kogoś przypisane");
        });
        Optional<User> user = userRepository.findById(userId);
        Optional<Asset> asset = assetRepository.findById(assetId);
        Assignment assignment = new Assignment();
        assignment.setUser(user.orElseThrow(() -> {
            throw new InvalidAssignmentException("Brak użytkownika z ID " + userId);
        }));
        assignment.setAsset(asset.orElseThrow(() -> {
            throw new InvalidAssignmentException("Brak wyposażenia z ID " + assetId);
        }));
        Assignment savedAssignment = assignmentRepository.save(assignment);
        return AssignmentMapper.toDto(savedAssignment);

    }
}
